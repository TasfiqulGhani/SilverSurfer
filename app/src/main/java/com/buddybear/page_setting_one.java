package com.buddybear;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.util.Linkify;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class page_setting_one extends AppCompatActivity {

    ImageButton back_btn;
    TextView Tv;

    String first = "MTÜ Lastekaitse Liidu (www.lastekaitseliit.ee) ja Wise Estonia OÜ (www.wise.ee) koostöös valminud Sõber Karu mobiilirakendus on tööriist lapsevanemale, mis suunab lapsega veedetud aega paremini planeerima ja täisväärtuslikult kasutama. \n" +
            "\n" +
            "Mobiilirakendus on jaotatud kolmeks osaks: \n\n" +
            "Teadmised  – annab vanemale valiku praktiliste näpunäidetega kasvatusalaseid artikleid ja videoid ja selgitab rakendusega seotud olulisi märksõnu.\n" +
            "\nEesmärgid – aitab vanemal valida ja lisada eesmärke, mida ja miks lapsega koos ette võtta võiks, ning näitab, kas ja kuidas nende eesmärkide saavutamine õnnestub. \n" +
            "\nMäng – suunab last ja vanemat üheskoos argiseid askeldusi märkama ja mõtestama.\n" +
            "\n" +
            "Sõber Karu mobiilirakendus on loodud MTÜ Lastekaitse Liit projekti „Kiusamisest vaba lasteaed ja kool“ raames. Projekti eesmärgiks on tagada Taanist pärit tõenduspõhise kiusamist ennetava metoodika „Kiusamisest vabaks!“ toimimine Eesti lasteaedades ja koolides. \n" +
            "\n" +
            "Projekt on rahastatud Euroopa Majanduspiirkonna (EMP) toetuste programmi „Riskilapsed ja –noored“ avatud taotlusvoorust „Kaasamine ja sekkumised haridussüsteemis“. Programmi viivad üheskoos ellu Haridus- ja Teadusministeerium, Justiitsministeerium ja Sotsiaalministeerium. Programmi rakendusüksuseks on Eesti Noorsootöö Keskus ning partneriks Norra Kohalike Omavalitsuste ja Regionaalsete Omavalitsuste Liit. \n";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programmist_layout);

        back_btn = (ImageButton) findViewById(R.id.back);
        Tv = (TextView) findViewById(R.id.tv);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });


        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/gillsans.ttf");

            Tv.setText(first);
            Tv.setTypeface(font);
            Linkify.addLinks(Tv, Linkify.ALL);







    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }


}
