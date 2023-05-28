package ueb18;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

class Ueb18FassadeTest {
    CD cd_bestand3_preis5;
    CD cd_bestand3_preis6;
    CD cd_bestand4_preis5;
    Buch buch_bestand3_preis5;
    Buch buch_bestand3_preis6;
    Buch buch_bestand4_preis5;
    Video video_bestand3_preis5;
    Video video_bestand3_preis6;
    Video video_bestand4_preis5;
    CD s_cd_bestand3_preis5;
    CD s_cd_bestand3_preis6;
    CD s_cd_bestand4_preis5;
    Buch s_buch_bestand3_preis5;
    Buch s_buch_bestand3_preis6;
    Buch s_buch_bestand4_preis5;
    Video s_video_bestand3_preis5;
    Video s_video_bestand3_preis6;
    Video s_video_bestand4_preis5;
    Lager publicLager;

    @BeforeEach
    void artikelInitialisierung(){
        cd_bestand3_preis5 = new CD(1234, 3, 5.0, "Kalle", "Whoop", 5);
        cd_bestand3_preis6 = new CD(1235, 3, 6.0, "Kalle", "Whoop", 5);
        cd_bestand4_preis5 = new CD(1236, 4, 5.0, "Kalle", "Whoop", 5);

        buch_bestand3_preis5 = new Buch(1237, 3, 5.0, "Harry", "Potter", "Klett");
        buch_bestand3_preis6 = new Buch(1238, 3, 6.0, "Harry", "Potter", "Klett");
        buch_bestand4_preis5 = new Buch(1239, 4, 5.0, "Harry", "Potter", "Klett");

        video_bestand3_preis5 = new Video(1244, 3, 5.0, "Gun", 3, 2022);
        video_bestand3_preis6 = new Video(1254, 3, 6.0, "Gun", 3, 2022);
        video_bestand4_preis5 = new Video(1264, 4, 5.0, "Gun", 3, 2022);

        s_cd_bestand3_preis5 = new CD(1234, 3, 5.0, "Kalle", "Whoop", 5);
        s_cd_bestand3_preis6 = new CD(1235, 3, 6.0, "Kalle", "Whoop", 5);
        s_cd_bestand4_preis5 = new CD(1236, 4, 5.0, "Kalle", "Whoop", 5);

        s_buch_bestand3_preis5 = new Buch(1237, 3, 5.0, "Harry", "Potter", "Klett");
        s_buch_bestand3_preis6 = new Buch(1238, 3, 6.0, "Harry", "Potter", "Klett");
        s_buch_bestand4_preis5 = new Buch(1239, 4, 5.0, "Harry", "Potter", "Klett");

        s_video_bestand3_preis5 = new Video(1244, 3, 5.0, "Gun", 3, 2022);
        s_video_bestand3_preis6 = new Video(1254, 3, 6.0, "Gun", 3, 2022);
        s_video_bestand4_preis5 = new Video(1264, 4, 5.0, "Gun", 3, 2022);

        publicLager = new Lager();
        publicLager.legeAnArtikel(cd_bestand3_preis6);
        publicLager.legeAnArtikel(cd_bestand4_preis5);
        publicLager.legeAnArtikel(cd_bestand3_preis5);
        publicLager.legeAnArtikel(buch_bestand3_preis6);
        publicLager.legeAnArtikel(buch_bestand4_preis5);
        publicLager.legeAnArtikel(buch_bestand3_preis5);
        publicLager.legeAnArtikel(video_bestand3_preis6);
        publicLager.legeAnArtikel(video_bestand4_preis5);
        publicLager.legeAnArtikel(video_bestand3_preis5);

    }

    @Test
    void aufgabe_c_i() {
        publicLager = new Lager();
        publicLager.legeAnArtikel(video_bestand3_preis5);
        publicLager.legeAnArtikel(cd_bestand3_preis6);
        publicLager.legeAnArtikel(buch_bestand3_preis6);
        publicLager.legeAnArtikel(video_bestand4_preis5);
        publicLager.legeAnArtikel(cd_bestand4_preis5);
        publicLager.legeAnArtikel(buch_bestand4_preis5);
        publicLager.legeAnArtikel(cd_bestand3_preis5);
        publicLager.legeAnArtikel(buch_bestand3_preis5);
        publicLager.legeAnArtikel(video_bestand3_preis6);



        Lager erwartetesLager = new Lager();
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);

        Assertions.assertArrayEquals(new Ueb18Fassade().aufgabe_c_i(publicLager), erwartetesLager.getLager());

    }

    @Test
    void aufgabe_c_ii() {
        Lager erwartetesLager = new Lager();
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);
        erwartetesLager.aenderePreisAllerArtikel(-10);

        new Ueb18Fassade().aufgabe_c_ii(publicLager);
        Assertions.assertArrayEquals(publicLager.getLager(), erwartetesLager.getLager());

    }

    @Test
    void aufgabe_c_iii() {
        Lager erwartetesLager = new Lager();

        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);

        for(int i = 0; i < 9; i++){
            Artikel artikel = erwartetesLager.getArtikel(i);
            artikel.setArt(artikel.getArt() + " (Sonderangebot)");
        }

        new Ueb18Fassade().aufgabe_c_iii(publicLager);
        Assertions.assertArrayEquals(publicLager.getLager(), erwartetesLager.getLager());
    }

    @Test
    void aufgabe_c_iv() {
        Lager erwartetesLager = new Lager();

        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);

        for(int i = 0; i < 9; i++){
            Artikel artikel = erwartetesLager.getArtikel(i);
            artikel.setArt(artikel.getArt() + " (Sonderangebot)");
        }
        erwartetesLager.aenderePreisAllerArtikel(-10);

        new Ueb18Fassade().aufgabe_c_iv(publicLager);
        Assertions.assertArrayEquals(publicLager.getLager(), erwartetesLager.getLager());
    }

    @Test
    void aufgabe_h_i() {
        Lager erwartetesLager = new Lager();
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);
        erwartetesLager.aenderePreisEinesArtikels(1234, 10);
        erwartetesLager.aenderePreisEinesArtikels(1235, 10);
        erwartetesLager.aenderePreisEinesArtikels(1236, 10);

        new Ueb18Fassade().aufgabe_h_i(publicLager);
        Assertions.assertArrayEquals(publicLager.getLager(), erwartetesLager.getLager());
    }

    @Test
    void aufgabe_h_ii() {
        Lager erwartetesLager = new Lager();
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);
        erwartetesLager.bucheAbgang(1234, 2);
        erwartetesLager.bucheAbgang(1238, 2);
        erwartetesLager.bucheAbgang(1244, 1);
        erwartetesLager.aenderePreisEinesArtikels(1234, -5);
        erwartetesLager.aenderePreisEinesArtikels(1238, -5);
        erwartetesLager.aenderePreisEinesArtikels(1244, -5);


        publicLager.bucheAbgang(1234, 2);
        publicLager.bucheAbgang(1238, 2);
        publicLager.bucheAbgang(1244, 1);

        new Ueb18Fassade().aufgabe_h_ii(publicLager);
        Assertions.assertArrayEquals(publicLager.getLager(), erwartetesLager.getLager());

    }

    @Test
    void aufgabe_h_iii() {
        Lager erwartetesLager = new Lager();
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);
        ((Buch)erwartetesLager.getArtikel(4)).setAutor("Max");
        erwartetesLager.aenderePreisEinesArtikels(1237, -5);
        erwartetesLager.aenderePreisEinesArtikels(1238, -5);

        ((Buch)publicLager.getArtikel(4)).setAutor("Max");

        new Ueb18Fassade().aufgabe_h_iii(publicLager, "Potter");
        Assertions.assertArrayEquals(publicLager.getLager(), erwartetesLager.getLager());
    }

    @Test
    void aufgabe_h_iv() {
        Lager erwartetesLager = new Lager();
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_cd_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_cd_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_buch_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_buch_bestand3_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis6);
        erwartetesLager.legeAnArtikel(s_video_bestand4_preis5);
        erwartetesLager.legeAnArtikel(s_video_bestand3_preis5);
        erwartetesLager.aenderePreisEinesArtikels(1234, 10);
        erwartetesLager.aenderePreisEinesArtikels(1235, 10);
        erwartetesLager.aenderePreisEinesArtikels(1236, 10);
        erwartetesLager.bucheAbgang(1234, 2);
        erwartetesLager.bucheAbgang(1238, 2);
        erwartetesLager.bucheAbgang(1244, 1);
        erwartetesLager.aenderePreisEinesArtikels(1234, -5);
        erwartetesLager.aenderePreisEinesArtikels(1238, -5);
        erwartetesLager.aenderePreisEinesArtikels(1244, -5);


        publicLager.bucheAbgang(1234, 2);
        publicLager.bucheAbgang(1238, 2);
        publicLager.bucheAbgang(1244, 1);


        new Ueb18Fassade().aufgabe_h_iv(publicLager);
        Assertions.assertArrayEquals(publicLager.getLager(), erwartetesLager.getLager());
    }

    @Test
    void aufgabe_h_v() {
        Lager lager = new Lager(15);
        lager.legeAnArtikel(new Buch(1239,"A","Habbz","A"));
        lager.legeAnArtikel(new Buch(1236,"A","c","A"));
        lager.legeAnArtikel(new Buch(1233,"A","Aabbc","A"));
        lager.legeAnArtikel(new Buch(1231,"A","aaaa","A"));
        lager.legeAnArtikel(new Buch(1235,"A","bAbbc","A"));
        lager.legeAnArtikel(new Buch(1241,"A","kk","A"));
        lager.legeAnArtikel(new Buch(1234,"A","Aacbc","A"));
        lager.legeAnArtikel(new Buch(1232,"A","aaaa","A"));
        lager.legeAnArtikel(new Buch(1238,"A","Habbc","A"));
        lager.legeAnArtikel(new Buch(1242,"A","kk","A"));
        lager.legeAnArtikel(new Buch(1237,"A","c","A"));

        Lager erwartetesLager = new Lager(11);
        erwartetesLager.legeAnArtikel(new Buch(1231,"A","aaaa","A"));
        erwartetesLager.legeAnArtikel(new Buch(1232,"A","aaaa","A"));
        erwartetesLager.legeAnArtikel(new Buch(1233,"A","Aabbc","A"));
        erwartetesLager.legeAnArtikel(new Buch(1234,"A","Aacbc","A"));
        erwartetesLager.legeAnArtikel(new Buch(1235,"A","bAbbc","A"));
        erwartetesLager.legeAnArtikel(new Buch(1236,"A","c","A"));
        erwartetesLager.legeAnArtikel(new Buch(1237,"A","c","A"));
        erwartetesLager.legeAnArtikel(new Buch(1238,"A","Habbc","A"));
        erwartetesLager.legeAnArtikel(new Buch(1239,"A","Habbz","A"));
        erwartetesLager.legeAnArtikel(new Buch(1241,"A","kk","A"));
        erwartetesLager.legeAnArtikel(new Buch(1242,"A","kk","A"));


        Assertions.assertArrayEquals(erwartetesLager.getLager(), new Ueb18Fassade().aufgabe_h_v(lager));
    }

    @Test
    void aufgabe_h_vi() {
        Lager lager = new Lager();
        lager.legeAnArtikel(new Buch(1231, 1.0, "Bla", "Harry", "Klett"));
        lager.legeAnArtikel(new Buch(1232, 2.0, "Bla", "Potter", "Klett"));
        lager.legeAnArtikel(new Buch(1233, 3.0, "Bla", "Angela", "Klett"));
        lager.legeAnArtikel(new Buch(1234, 4.0, "Bla", "Harry", "Klett"));
        lager.legeAnArtikel(new Buch(1235, 5.0, "Bla", "Wolfgang", "Klett"));
        lager.legeAnArtikel(new Buch(1236, 6.0, "Bla", "Harry", "Klett"));
        lager.legeAnArtikel(new Buch(1237, 7.0, "Bla", "Harry", "Klett"));
        lager.legeAnArtikel(new Buch(1238, 8.0, "Bla", "Helmut", "Klett"));
        lager.legeAnArtikel(new Buch(1239, 9.0, "Bla", "Hildegard", "Klett"));
        lager.legeAnArtikel(new Buch(1230, 10.0, "Bla", "Winfred", "Klett"));

        Lager erwartetesLager = new Lager(2);
        erwartetesLager.legeAnArtikel(new Buch(1234, 4.0, "Bla", "Harry", "Klett"));
        erwartetesLager.legeAnArtikel(new Buch(1236, 6.0, "Bla", "Harry", "Klett"));

        Assertions.assertArrayEquals(erwartetesLager.getLager(),
                                new Ueb18Fassade().aufgabe_h_vi(lager, "Harry",4.0,6.0));

    }
}