import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {

        List<Echipament> lista_echipamente = new ArrayList<Echipament>();
        Scanner sc = new Scanner(System.in);
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/Users/danieljurma/Documents/poli anul 3/semestrul 1/lab-sapt4-jurma/src/echipamente.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] informatii = line.split(";");
                situatie situatieEnum = situatie.valueOf(informatii[4]);

                switch (informatii[5]) {
                    case "imprimanta":
                        int ppm = Integer.parseInt(informatii[6]);
                        String rezolutie = informatii[7];
                        int p_car = Integer.parseInt(informatii[8]);
                        mod_tiparire modTiparire = mod_tiparire.valueOf(informatii[9]);
                        Imprimanta imprimanta = new Imprimanta(informatii[0], Integer.parseInt(informatii[1]), Integer.parseInt(informatii[2]), informatii[3], situatieEnum, ppm, rezolutie, p_car, modTiparire);
                        lista_echipamente.add(imprimanta);
                        break;
                    case "copiator":
                        int p_ton = Integer.parseInt(informatii[6]);
                        format_copiere formatHartie = format_copiere.valueOf(informatii[7]);
                        Copiator copiator = new Copiator(informatii[0], Integer.parseInt(informatii[1]), Integer.parseInt(informatii[2]), informatii[3], situatieEnum, p_ton, formatHartie);
                        lista_echipamente.add(copiator);
                        break;
                    case "sistem de calcul":
                        String tipMonitor = informatii[6];
                        String vitezaProcesor = informatii[7];
                        int capacitateHDD = Integer.parseInt(informatii[8]);
                        sistem_operare sistemOperare = sistem_operare.valueOf(informatii[9]);
                        SistemCalcul sistemCalcul = new SistemCalcul(informatii[0], Integer.parseInt(informatii[1]), Integer.parseInt(informatii[2]), informatii[3], situatieEnum, tipMonitor, vitezaProcesor, capacitateHDD, sistemOperare);
                        lista_echipamente.add(sistemCalcul);
                        break;
                }
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int optiune = 0;
        System.out.println("------------------- MENIU -------------------");
        System.out.println("1.Afişarea tuturor echipamentelor");
        System.out.println("2. Afişarea imprimantelor");
        System.out.println("3. Afişarea copiatoarelor");
        System.out.println("4. Afişarea sistemelor de calcul");
        System.out.println("5. Modificarea stării în care se află un echipament");
        System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimantă");
        System.out.println("7. Setarea unui format de copiere pentru copiatoare");
        System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul ");
        System.out.println("9. Afişarea echipamentelor vândute");
        System.out.println("10. Să se realizeze două metode statice pentru serializarea / deserializarea colecției de" + "obiecte în fișierul echip.bin");
        System.out.println("11. Exit");
        do {
            System.out.println("Optiune: ");
            optiune = sc.nextInt();
            switch (optiune) {
                case 1:
                    for (Echipament echipament : lista_echipamente) {
                        System.out.println("---------------------------------------------");
                        System.out.println("Denumire: " + echipament.denumire);
                        System.out.println("Numar inventar: " + echipament.nr_inv);
                        System.out.println("Pret: " + echipament.pret);
                        System.out.println("Zona magazin: " + echipament.zona_mag);
                        System.out.println("Situatie: " + echipament.situatie);

                        // Alte detalii specifice fiecărui tip de echipament
                        if (echipament instanceof Imprimanta) {
                            Imprimanta imprimanta = (Imprimanta) echipament;
                            System.out.println("PPM: " + imprimanta.ppm);
                            System.out.println("Rezolutie: " + imprimanta.rezolutie);
                            System.out.println("P_car: " + imprimanta.p_car);
                            System.out.println("Mod Tiparire: " + imprimanta.mod_tiparire);
                        } else if (echipament instanceof Copiator) {
                            Copiator copiator = (Copiator) echipament;
                            System.out.println("P_ton: " + copiator.p_ton);
                            System.out.println("Format copiere: " + copiator.format_copiere);
                        } else if (echipament instanceof SistemCalcul) {
                            SistemCalcul sistemCalcul = (SistemCalcul) echipament;
                            System.out.println("Tip Monitor: " + sistemCalcul.tip_mon);
                            System.out.println("Viteza Procesor: " + sistemCalcul.vit_proc);
                            System.out.println("Capacitate HDD: " + sistemCalcul.c_hdd);
                            System.out.println("Sistem de Operare: " + sistemCalcul.sistem_operare);
                        }
                        System.out.println(); // Adaugăm o linie goală între echipamente
                    }
                    break;
                case 2:
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament instanceof Imprimanta) {
                            System.out.println("---------------------------------------------");
                            System.out.println("Denumire: " + echipament.denumire);
                            System.out.println("Numar inventar: " + echipament.nr_inv);
                            System.out.println("Pret: " + echipament.pret);
                            System.out.println("Zona magazin: " + echipament.zona_mag);
                            System.out.println("Situatie: " + echipament.situatie);

                            // Alte detalii specifice fiecărui tip de echipament

                            Imprimanta imprimanta = (Imprimanta) echipament;
                            System.out.println("PPM: " + imprimanta.ppm);
                            System.out.println("Rezolutie: " + imprimanta.rezolutie);
                            System.out.println("P_car: " + imprimanta.p_car);
                            System.out.println("Mod Tiparire: " + imprimanta.mod_tiparire);
                            System.out.println(); // Adaugăm o linie goală între echipamente

                        }
                    }
                    break;
                case 3:
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament instanceof Copiator) {
                            System.out.println("---------------------------------------------");
                            System.out.println("Denumire: " + echipament.denumire);
                            System.out.println("Numar inventar: " + echipament.nr_inv);
                            System.out.println("Pret: " + echipament.pret);
                            System.out.println("Zona magazin: " + echipament.zona_mag);
                            System.out.println("Situatie: " + echipament.situatie);

                            // Alte detalii specifice fiecărui tip de echipament
                            Copiator copiator = (Copiator) echipament;
                            System.out.println("P_ton: " + copiator.p_ton);
                            System.out.println("Format copiere: " + copiator.format_copiere);

                            System.out.println(); // Adaugăm o linie goală între echipamente

                        }
                    }
                    break;
                case 4:
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament instanceof SistemCalcul) {
                            System.out.println("---------------------------------------------");
                            System.out.println("Denumire: " + echipament.denumire);
                            System.out.println("Numar inventar: " + echipament.nr_inv);
                            System.out.println("Pret: " + echipament.pret);
                            System.out.println("Zona magazin: " + echipament.zona_mag);
                            System.out.println("Situatie: " + echipament.situatie);

                            // Alte detalii specifice fiecărui tip de echipament
                            SistemCalcul sistemCalcul = (SistemCalcul) echipament;
                            System.out.println("Tip Monitor: " + sistemCalcul.tip_mon);
                            System.out.println("Viteza Procesor: " + sistemCalcul.vit_proc);
                            System.out.println("Capacitate HDD: " + sistemCalcul.c_hdd);
                            System.out.println("Sistem de Operare: " + sistemCalcul.sistem_operare);

                            System.out.println(); // Adaugăm o linie goală între echipamente

                        }
                    }
                    break;
                case 5:
                    System.out.println("Introduceti numarul de inventar al echipamentului: ");
                    int nrInv = sc.nextInt();
                    sc.nextLine(); // Consumăm newline
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament.nr_inv == nrInv) {
                            System.out.println("Introduceti noua stare (achizitionat, expus, vandut): ");
                            String newSituatie = sc.nextLine().toLowerCase();
                            echipament.situatie = situatie.valueOf(newSituatie);
                            System.out.println("Starea echipamentului a fost actualizata cu succes.");
                            break; // Oprim bucla după ce am găsit echipamentul
                        }
                    }
                    break;
                case 6:
                    System.out.println("Introduceti numarul de inventar al imprimantei: ");
                    int nrInvImprimanta = sc.nextInt();
                    sc.nextLine(); // Consumăm newline
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament instanceof Imprimanta && echipament.nr_inv == nrInvImprimanta) {
                            Imprimanta imprimanta = (Imprimanta) echipament;
                            System.out.println("Introduceti noul mod de scriere (color sau albnegru): ");
                            String newModTiparire = sc.nextLine().toLowerCase();
                            imprimanta.mod_tiparire = mod_tiparire.valueOf(newModTiparire);
                            System.out.println("Modul de scriere al imprimantei a fost actualizat cu succes.");
                            break; // Oprim bucla după ce am găsit imprimanta
                        }
                    }
                    break;
                case 7:
                    System.out.println("Introduceti numarul de inventar al copiatorului: ");
                    int nrInvCopiator = sc.nextInt();
                    sc.nextLine(); // Consumăm newline
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament instanceof Copiator && echipament.nr_inv == nrInvCopiator) {
                            Copiator copiator = (Copiator) echipament;
                            System.out.println("Introduceti noul format de copiere(A3, A4): ");
                            String newFormatHartie = sc.nextLine();
                            copiator.format_copiere = format_copiere.valueOf(newFormatHartie);
                            System.out.println("Formatul de copiere al copiatorului a fost actualizat cu succes.");
                            break; // Oprim bucla după ce am găsit copiatorul
                        }
                    }
                    break;
                case 8:
                    System.out.println("Introduceti numarul de inventar al sistemului de calcul: ");
                    int nrInvSistemCalcul = sc.nextInt();
                    sc.nextLine(); // Consumăm newline
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament instanceof SistemCalcul && echipament.nr_inv == nrInvSistemCalcul) {
                            SistemCalcul sistemCalcul = (SistemCalcul) echipament;
                            System.out.println("Introduceti noul sistem de operare (windows sau linux): ");
                            String newSistemOperare = sc.nextLine();
                            sistemCalcul.sistem_operare = sistem_operare.valueOf(newSistemOperare);
                            System.out.println("Sistemul de operare al sistemului de calcul a fost actualizat cu succes.");
                            break; // Oprim bucla după ce am găsit sistemul de calcul
                        }
                    }
                    break;
                case 9:
                    System.out.println("Echipamente vândute:");
                    for (Echipament echipament : lista_echipamente) {
                        if (echipament.situatie == situatie.vandut) {
                            System.out.println("---------------------------------------------");
                            System.out.println("Denumire: " + echipament.denumire);
                            System.out.println("Numar inventar: " + echipament.nr_inv);
                            System.out.println("Pret: " + echipament.pret);
                            System.out.println("Zona magazin: " + echipament.zona_mag);
                            System.out.println("Situatie: " + echipament.situatie);

                            // Alte detalii specifice fiecărui tip de echipament
                            if (echipament instanceof Imprimanta) {
                                Imprimanta imprimanta = (Imprimanta) echipament;
                                System.out.println("PPM: " + imprimanta.ppm);
                                System.out.println("Rezolutie: " + imprimanta.rezolutie);
                                System.out.println("P_car: " + imprimanta.p_car);
                                System.out.println("Mod Tiparire: " + imprimanta.mod_tiparire);
                            } else if (echipament instanceof Copiator) {
                                Copiator copiator = (Copiator) echipament;
                                System.out.println("P_ton: " + copiator.p_ton);
                                System.out.println("Format copiere: " + copiator.format_copiere);
                            } else if (echipament instanceof SistemCalcul) {
                                SistemCalcul sistemCalcul = (SistemCalcul) echipament;
                                System.out.println("Tip Monitor: " + sistemCalcul.tip_mon);
                                System.out.println("Viteza Procesor: " + sistemCalcul.vit_proc);
                                System.out.println("Capacitate HDD: " + sistemCalcul.c_hdd);
                                System.out.println("Sistem de Operare: " + sistemCalcul.sistem_operare);
                            }
                            System.out.println(); // Adaugăm o linie goală între echipamente
                        }
                    }
                    break;
                case 10:
                    System.out.println("1. Serializare colecție de echipamente");
                    System.out.println("2. Deserializare colecție de echipamente");
                    int optiuneSerializare = sc.nextInt();
                    sc.nextLine(); // Consumăm newline
                    switch (optiuneSerializare) {
                        case 1:
                            EchipamentSerialization.serialize(lista_echipamente);
                            break;
                        case 2:
                            System.out.println("Inca trebuie lucrat la implementatie...");
                            break;
                        default:
                            System.out.println("Opțiune invalidă.");
                    }
                    break;
                case 11:
                    exit(0);
                    break;

            }

        } while (optiune != 11);

    }
}