package hu.i_host.thespiralkata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;

public class SpiralActivity extends AppCompatActivity {
    @BindView(R.id.spinner)
    Spinner mSpinner;

    @BindView(R.id.result)
    TextView result;

    @Inject
    ArrayAdapter mAdapter;

    @Inject
    SpiralTable mSpiralTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiral);

        // DI injects the objects
        ((MainApplication) getApplication()).getSpiralActivityComponent().inject(this);

        // For binding view
        ButterKnife.bind(this);

        // Specify the layout to use when the list of choices appears
        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        mSpinner.setAdapter(mAdapter);
    }

    @OnItemSelected(R.id.spinner)
    public void spinnerClick() {
        int dimension = Integer.parseInt((String)mSpinner.getSelectedItem());

        result.setMaxLines(dimension);
        result.setLines(dimension);

        mSpiralTable.init();
        int[][] matrix = mSpiralTable.go(dimension);

        String matrixString = "";

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                matrixString += Integer.toString(matrix[i][j]);
            }
            matrixString += "\n";
        }

        result.setText(matrixString);

        Toast.makeText(this,
                "The Spiral table generate in " + Integer.toString(dimension) + " dimensions.", Toast.LENGTH_SHORT).show();
    }
}
