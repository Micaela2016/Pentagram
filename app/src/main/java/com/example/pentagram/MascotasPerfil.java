package com.example.pentagram;

public class MascotasPerfil {

    private int fotoPerro;
    private int Megusta;
    int hueso_amarillo;

    public MascotasPerfil(int fotoPerro, int megusta, int hueso_amarillo) {
        this.fotoPerro = fotoPerro;
        Megusta = megusta;
        this.hueso_amarillo = hueso_amarillo;
    }

    public int getFotoPerro() {
        return fotoPerro;
    }

    public void setFotoPerro(int fotoPerro) {
        this.fotoPerro = fotoPerro;
    }

    public int getMegusta() {
        return Megusta;
    }

    public void setMegusta(int megusta) {
        Megusta = megusta;
    }

    public int getHueso_amarillo() {
        return hueso_amarillo;
    }

    public void setHueso_amarillo(int hueso_amarillo) {
        this.hueso_amarillo = hueso_amarillo;
    }
}
