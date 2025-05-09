package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private CustomHashMap<String,Book> bookMap ;

    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        bookMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        bookMap.put(book.getIsbn(),book);
    }

    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        return bookMap.containsKey(isbn);
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book temp = getBookByIsbn(isbn);
        temp.setAvailable(available);
        bookMap.put(isbn, temp);
    }

    public void addToWaitlist(String isbn, String memberId) {
        bookMap.get(isbn).addToWaitlist(memberManager.getMember(memberId));
    }

    public Member getNextFromWaitlist(String isbn) {
        return bookMap.get(isbn).getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        return bookMap.get(isbn).hasWaitlist();
    }
}