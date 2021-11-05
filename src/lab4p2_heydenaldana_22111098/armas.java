package lab4p2_heydenaldana_22111098;


enum armas 
{
    ARMAB(50), BOMBA(150), ESCOPETA(140), LANZALLAMAS(110);
    
    private int ataque;
    
    // Constructor 
    armas(int ataque)
    {
        this.ataque = ataque;
    }
    
    // funcion get ataque
    int getAtaque()
    {
        return ataque;
    }
}
