package com.example.Analyzor;

import com.example.readers.CoupleStats;

import java.util.List;

public interface Analyzor {
    List<CoupleStats> analyse(List<String> contenu);
}
