package org.java.lessons.travelagency;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Agency {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            try {
                System.out.println("Vuoi prenotare una vacanza? Inserisci si o no");
                String scelta = input.nextLine();
                if (scelta.equalsIgnoreCase("no")) {
                    continua = false;
                    System.out.println("Ok, Ciao Ciao!");
                } else if (scelta.equalsIgnoreCase("si")) {
                    System.out.println("Inserire la destinazione:");
                    String destinazione = input.nextLine();

                    System.out.println("Inserire la data di inizio della vacanza (ES: yyyy-MM-dd):");
                    String dataInizioString = input.nextLine();
                    LocalDate dateStart = LocalDate.parse(dataInizioString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    System.out.println("Inserire la data della fine della vacanza (ES: yyyy-MM-dd):");
                    String dataFineString = input.nextLine();
                    LocalDate dateFine = LocalDate.parse(dataFineString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    Vacancy vacanza = new Vacancy(destinazione, dateStart, dateFine);
                    System.out.println("Hai prenotato una vacanza di " + vacanza.durationVacancy() + " giorni a " +
                            vacanza.getDestination() + " dal " + vacanza.getDateStart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                            " al " + vacanza.getDateFine().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                } else {
                    System.out.println("Comando non valido. Riprova.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Errore durante la prenotazione: " + e.getMessage());
            }
        }


    }
}

