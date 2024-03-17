package com.example.application;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        recyclerView = findViewById(R.id.ListOfData);
        adapter = new Adapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        List<DataModel> data = readExcelFileFromRaw(); // Modify this line to get List<DataModel> instead of List<String>
        adapter.setData(data);
    }

    private List<DataModel> readExcelFileFromRaw() {
        List<DataModel> data = new ArrayList<>();
        try {
            // Open the Excel file stored in the raw folder
            InputStream inputStream = getResources().openRawResource(R.raw.book); // Replace "your_excel_file" with the actual file name without extension

            // Create a Workbook object from the input stream
            Workbook workbook = WorkbookFactory.create(inputStream);

            // Assuming data is in the first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate over rows
            for (Row row : sheet) {
                // Assuming each row contains text in the first cell and image URL in the second cell
                Cell textCell = row.getCell(0);
                Cell imageCell = row.getCell(1);

                String text = textCell.getStringCellValue();
                String imageUrl = imageCell.getStringCellValue();

                // Create a DataModel object and add it to the list
                DataModel dataModel = new DataModel(text, imageUrl);
                data.add(dataModel);
            }

            // Close the workbook and input stream
            workbook.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(MainActivity5.this, "Error while reading Excel file", Toast.LENGTH_SHORT).show();
        }
        return data;
    }
}
