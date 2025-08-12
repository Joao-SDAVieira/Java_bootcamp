public class Computador implements VideoPlayer, MusicPlayer{
    @Override
    public void playMusic() {
        System.out.println("Smartphone Tocando música");
    }

    @Override
    public void pauseMusic() {
        System.out.println("Smartphone Pausando música");
    }

    @Override
    public void stopMusic() {
        System.out.println("Smartphone parando música");
    }

    @Override
    public void playVideo() {
        System.out.println("Smartphone Tocando video");
    }

    @Override
    public void pauseVideo() {
        System.out.println("Smartphone Pausando video");
    }

    @Override
    public void stopVideo() {
        System.out.println("Smartphone parando video");
    }
}
