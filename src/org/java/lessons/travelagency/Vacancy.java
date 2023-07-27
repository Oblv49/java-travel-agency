package org.java.lessons.travelagency;

/*
*    Consegna Nel progetto java-travel-agency, creare la classe Vacanza caratterizzata da:
*    - destinazione
*    - data inizio
*    - data fineQuando viene creata una nuova Vacanza vanno effettuati dei controlli:
*    - destinazione, data inizio e data fine non possono essere null
*    - la data inizio non può essere già passata
*    - la data fine non può essere prima della data inizio
*    Se fallisce la validazione vanno sollevate opportune eccezioni
*/

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Vacancy {
    //declaration variables
    private String destination;
    private LocalDate dateStart;
    private LocalDate dateFine;

    public Vacancy(String destination, LocalDate dateStart, LocalDate dateFine) {
        if (destination == null || dateStart == null || dateFine == null) {
            throw new IllegalArgumentException("Destinazione, data di inizio e data di fine devono essere specificate.");
        }
        if (dateStart.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Inserisci una data valida.");
        }
        if (dateFine.isBefore(dateStart)) {
            throw new IllegalArgumentException("La data di fine non può essere prima della data di inizio.");
        }

        this.destination = destination;
        this.dateStart = dateStart;
        this.dateFine = dateFine;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public LocalDate getDateFine() {
        return dateFine;
    }

    public long durationVacancy() {
        return dateStart.until(dateFine, java.time.temporal.ChronoUnit.DAYS);
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "destination='" + destination + '\'' +
                ", dateStart=" + dateStart +
                ", dateFine=" + dateFine +
                '}';
    }

}
