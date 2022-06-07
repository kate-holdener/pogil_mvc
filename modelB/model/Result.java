package model;

/**
 * Enumeration type with possible outcomes of the game
 */
public enum Result{
    WIN("win"), 
    LOSE("lose"), 
    TIE("tie");

    private final String result;
    Result(String s)
    {
        this.result = s;
    }
}
