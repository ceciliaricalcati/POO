import java.awt.Color;

public class Ponto implements ElementoMapa{
  private Color cor;
  private Character simbolo;
  
  public Ponto(Character simbolo, Color cor){
    this.simbolo = simbolo;
    this.cor = cor;
  }

  @Override
  public Character getSimbolo() {
    return simbolo;
  }

  @Override
  public Color getCor() {
    return cor;
  }

  @Override
  public boolean podeSerAtravessado() {
    return false;
  }

  @Override
  public boolean podeInteragir() {
    return true;
  }

  @Override
  public String interage() {
    return null;
  }

  @Override
  public int getX() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getX'");
  }

  @Override
  public int getY() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getY'");
  }

}








