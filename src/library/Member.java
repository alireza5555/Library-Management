package library;

import datastructures.stacks.CustomStack;

public class Member {
    private String memberId;
    private String name;
    CustomStack stack;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        stack = new CustomStack(50);
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        stack.add(transaction);
    }

    public Transaction getLastTransaction() {
        stack.peek();
        return null;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
