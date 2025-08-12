public non-sealed class RelogioBrasileiro extends Relogio {

    @Override
    public Relogio converter(final Relogio relogio){
        this.segundos = relogio.getSegundos();
        this.minutos = relogio.getMinutos();
        switch (relogio){
            case RelogioAmericano relogioAmericano -> this.horas = (relogioAmericano.getIndicadorPeriodo().equals("PM")) ?
                        relogioAmericano.getHoras() + 12:
                        relogioAmericano.getHoras();
            case RelogioBrasileiro relogioBrasileiro -> this.horas = relogioBrasileiro.getHoras();

        }
        return this;
    }
}
