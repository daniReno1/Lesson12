package com.example.reno.fragmentexample;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MyFragment2 extends Fragment implements AdapterView.OnItemSelectedListener
{

    ArrayList<String> stringList2 = new ArrayList<String>();
    View view_a;
    Spinner spinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Bundle bundle = this.getArguments();
        stringList2 = bundle.getStringArrayList("theList");

        LinearLayout myLayout = new LinearLayout(getActivity());
        TextView t = new TextView(getActivity());
        t.setText(String.valueOf(stringList2.get(0)));

        spinner = new Spinner(getActivity());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1, stringList2);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        myLayout.addView(spinner);

        view_a = myLayout;

        return view_a;


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id)
    {
        if (spinner.getSelectedItemPosition() == 1)
        {
            Uri webpage = Uri.parse("https://www.linkedin.com/in/danielabrham10");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        }
        else if (spinner.getSelectedItemPosition() == 2)
        {
            Uri webpage = Uri.parse("https://online.cs.mum.edu/access/content/group/673e6125-476f-4e96-8242-7a8cc9d4f308/Suski%20Chart/CS473%20Mobile%20Data%20Programming%20Suskie%20Chart%20-%20Crater.pdf");
            Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
        // do nothing

    }


}