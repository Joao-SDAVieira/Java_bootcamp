public class MusicBox implements MusicPlayer{
    @Override
    public void playMusic() {
        System.out.println("Caixa de música Tocando música");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Caixa de música Pausando música");
    }

    @Override
    public void stopMusic() {
        System.out.println("Caixa de música parando música");
    }

}
