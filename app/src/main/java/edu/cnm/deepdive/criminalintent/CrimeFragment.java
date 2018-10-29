package edu.cnm.deepdive.criminalintent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;


public class CrimeFragment extends Fragment {
  private Crime crime;
  private EditText titleField;
  private Button dateButton;
  private CheckBox solvedCheckBox;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    crime = new Crime();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_crime, container, false);

    titleField = (EditText) v.findViewById(R.id.crime_title);
    titleField.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        //This space intentionally left blank.
      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {
        crime.setTitle(s.toString());
      }

      @Override
      public void afterTextChanged(Editable s) {
        //This one too.
      }
    });
    solvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
    solvedCheckBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        crime.setSolved(isChecked);
      }
    });
    dateButton = (Button) v.findViewById(R.id.crime_date);
    dateButton.setText(crime.getDate().toString());
    dateButton.setEnabled(false);

    return v;
  }

}
