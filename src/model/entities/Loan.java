package src.model.entities;

import java.time.LocalDate;

public class Loan {

    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Loan(Book book, LocalDate borrowDate) {
        this.book = book;
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void finishLoan(LocalDate returnDate) {
        this.returnDate = returnDate;
        book.giveBack();
    }

}
