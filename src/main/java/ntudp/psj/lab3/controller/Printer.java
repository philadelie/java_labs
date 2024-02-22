package ntudp.psj.lab3.controller;

public interface Printer<T> {
    void printCreationText(T obj);
    void printHeadInfo(T obj);
}
