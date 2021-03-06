package exemploLivro;

//import edu.udc.psw.modelo.manipulador.ManipuladorFormaGeometrica;
//import edu.udc.psw.modelo.manipulador.ManipuladorLinha;
//import edu.udc.psw.modelo.manipulador.ManipuladorPonto2D;

public class Ponto extends Object{
 
 private double x;
 private double y;

 public void setX(double x) {
 this.x = x;
 }

 public void setY(double y) {
 this.y = y;
 }
 
 public double getX() {
 return x;
 }

 public double getY() {
 return y;
 }

 public Ponto() {
 x = 0.0;
 y = 0.0;
 }
 
 public Ponto(double x, double y){
 this.x = x;
 this.y = y;
 }
 
 
 @Override
 public Ponto clone() {
 return new Ponto(x, y);
 }

 public double distancia(Ponto p){
 return Math.sqrt( (x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
 }

 @Override
 public String toString(){
 return String.format("Ponto %.2f %.2f", x, y);
 }

 //@Override
 public Ponto centro() {
 return clone();
 }

 //@Override
 public double area() {
 return 0;
 }

 //@Override
 public double perimetro() {
 return 0;
 }

 //@Override
 public double base() {
 return 0;
 }

 //@Override
 public double altura() {
 return 0;
 }

//@Override
//public ManipuladorFormaGeometrica getManipulador() {
//		return new ManipuladorPonto2D(this);
//	}
}