public class Computador implements VideoPlayer, MusicPlayer{
    @Override
    public void playMusic() {
        System.out.println("Computador Tocando música");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Computador Pausando música");
    }

    @Override
    public void stopMusic() {
        System.out.println("Computador parando música");
    }

    @Override
    public void playVideo() {
        System.out.println("Computador Tocando video");
    }

    @Override
    public void pauseVideo() {
        System.out.println("Computador Pausando video");
    }

    @Override
    public void stopVideo() {
        System.out.println("Computador parando video");
    }
}
