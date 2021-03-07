package com.kali.motivation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.kali.motivation.R;


public class QuoteFragment extends Fragment {

    TextView quoteName,quoteAuthe;
    CardView cardViewText,cardViewAuthe;

    public QuoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quote, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        quoteName=view.findViewById(R.id.quote_text);
        quoteAuthe=view.findViewById(R.id.quote_author);
        cardViewText=view.findViewById(R.id.card_text);
        cardViewAuthe=view.findViewById(R.id.cart_authe);


            String qoute =getArguments().getString("quote");
            String author =getArguments().getString("author");
            quoteName.setText(qoute);
            quoteAuthe.setText("by " + author);


    }
    public static final QuoteFragment newInstance(String quote,String author){
        QuoteFragment fragment=new QuoteFragment();
        Bundle bundle=new Bundle();
        bundle.putString("quote",quote);
        bundle.putString("author",author);
        fragment.setArguments(bundle);
        return fragment;
    }


}