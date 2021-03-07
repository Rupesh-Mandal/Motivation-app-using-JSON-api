package com.kali.motivation.inteface;

import com.kali.motivation.modle.Quoet;

import java.util.ArrayList;

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quoet> quoets);
}
