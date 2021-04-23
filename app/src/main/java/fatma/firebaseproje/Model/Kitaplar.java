package fatma.firebaseproje.Model;

public class Kitaplar {
    private String adi;
    private String yazar;
    private String yayinevi;
    private String sayi;
    private String tur;



    public Kitaplar (String adi, String yazar, String yayinevi, String sayi, String tur){
        this.adi=adi;
        this.yazar=yazar;
        this.yayinevi=yayinevi;
        this.sayi=sayi;
        this.tur=tur;
    }

    public Kitaplar(){

    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(String yayinevi) {
        this.yayinevi = yayinevi;
    }

    public String getSayi() {
        return sayi;
    }

    public void setSayi(String sayi) {
        this.sayi = sayi;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }


}
