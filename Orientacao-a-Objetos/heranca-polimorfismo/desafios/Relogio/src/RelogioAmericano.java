public non-sealed class RelogioAmericano extends Relogio {
    private String indicadorPeriodo;

    public String getIndicadorPeriodo() {
        return indicadorPeriodo;
    }

    public void setIndicadorPeriodo(String indicadorPeriodo) {
        this.indicadorPeriodo = indicadorPeriodo;
    }

    public void setAntesMeioDia(){
        this.indicadorPeriodo = "AM";
    }
    public void setDepoisMeioDia(){
        this.indicadorPeriodo = "PM";
    }

    public void setHoras(int horas) {
        setAntesMeioDia();
        if ((horas >= 12) && (horas <= 23)){
            setDepoisMeioDia();
            this.horas = horas - 12;
        } else if (horas >= 24) {
            this.horas = 0;
        } else {
            this.horas = horas;
        }
    }

    @Override
    public String getTime(){
        return super.getTime() + " " + this.indicadorPeriodo;
    }

    @Override
    Relogio converter(final Relogio relogio){
        this.segundos = relogio.getSegundos();
        this.minutos = relogio.getMinutos();
        switch (relogio){
            case RelogioAmericano relogioAmericano -> {
                this.horas = relogio.getHoras();
                this.indicadorPeriodo = relogioAmericano.getIndicadorPeriodo();
            }
            case RelogioBrasileiro relogioBrasileiro -> this.setHoras(relogioBrasileiro.getHoras());

        }
        return this;
    }
}
