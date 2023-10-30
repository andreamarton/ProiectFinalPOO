
package cabinetVeterinar;
public class CabinetVet  {

    public String numeStapan;
    public String specieAnimal;
    public String codCip;
    public int status;

    public CabinetVet(String numeStapan,String specieAnimal,String codCip,int status)
    {
        this.numeStapan=numeStapan;
        this.specieAnimal=specieAnimal;
        this.codCip=codCip;
        this.status=status;
    }
    public CabinetVet()
    {
    }
    public String getName(){
        return numeStapan;
    }
    public void setName(String newNumeStapan){
        this.numeStapan=newNumeStapan;
    }
    public void setStatus(int newStatus)
    {
        this.status=newStatus;
    }
    public int getStatus()
    {
        return status;
    }
    public String getSpecieAnimal()
    {
        return specieAnimal;
    }
    public void setSpecieAnimal(String newSpecie)
    {
        this.specieAnimal=newSpecie;
    }
    public String getCodCip(){
        return codCip;
    }
    public void setCodCip(String newCodCip){
        this.codCip=newCodCip;
    }
}

