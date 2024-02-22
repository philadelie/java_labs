package ntudp.psj.lab4.controller;

public interface Printer<T> {
    void printCreationText(T obj);
    void printHeadInfo(T obj);
}
