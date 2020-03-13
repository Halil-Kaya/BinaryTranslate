/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytranslete;

/**
 *
 * @author minter
 */

import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author halilmint
 */
public class BinaryTranslete {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
        AD: HALIL IBRAHIM
        SOYAD: KAYA
        NO: 172 122 1017
        
        incelediğiniz için teşşekür ederim
         */
        Scanner scan = new Scanner(System.in);
        System.out.print("birinci sayiyi giriniz: ");
        int birinciSayi = scan.nextInt();
        System.out.print("ikinci sayiyi giriniz: ");
        int ikinciSayi = scan.nextInt();
        String birinciTaban = binaryecevir(birinciSayi);
        String ikinciTaban = binaryecevir(ikinciSayi);
        System.out.println(birinciSayi + " nin ikili sisteme çevrilmiş hali: " + birinciTaban);
        System.out.println(ikinciSayi + " nin ikili sisteme çevrilmiş hali: " + ikinciTaban);

        if (birinciTaban.length() > ikinciTaban.length()) {

            int fark = birinciTaban.length() - ikinciTaban.length();

            for (; fark > 0; fark--) {

                ikinciTaban = "0" + ikinciTaban;

            }

        }

        if (birinciTaban.length() < ikinciTaban.length()) {

            int fark = ikinciTaban.length() - birinciTaban.length();

            for (; fark > 0; fark--) {

                birinciTaban = "0" + birinciTaban;

            }

        }

        ArrayList<Integer> birinciParcalar = new ArrayList<Integer>();
        birinciParcalar = bol(birinciTaban);
        ArrayList<Integer> ikinciParcalar = new ArrayList<Integer>();
        ikinciParcalar = bol(ikinciTaban);

        String sonuc = "";
        int carry = 0;

        for (int i = birinciParcalar.size() - 1; i >= 0; i--) {

            sonuc = (birinciParcalar.get(i) ^ ikinciParcalar.get(i) ^ carry) + sonuc;

            if ((birinciParcalar.get(i) + ikinciParcalar.get(i) + carry) >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }

        }
        if (carry == 1) {
            sonuc = carry + sonuc;
        }
        System.out.println("\nsonuc " + sonuc);

    }

    public static ArrayList<Integer> bol(String taban) {

        ArrayList<Integer> parcalar = new ArrayList<Integer>();

        for (int i = 0; i < taban.length(); i++) {
            parcalar.add(Integer.valueOf(String.valueOf(taban.charAt(i))));

        }

        return parcalar;
    }

    public static String binaryecevir(int sayi) {
        String taban = "";
        ArrayList<Integer> sayilar = new ArrayList<Integer>();
        int i = 0;
        while (sayi >= 1) {
            sayilar.add(sayi % 2);
            sayi = sayi / 2;

            i++;
        }

        for (int x = sayilar.size() - 1; x >= 0; x--) {
            taban = taban + sayilar.get(x);

        }

        return taban;
    }

}
