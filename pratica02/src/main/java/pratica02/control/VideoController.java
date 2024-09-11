package pratica02.control;

import java.util.List;

import pratica02.model.Video;

public class VideoController {
	
	private List<Video> videos;
	
	public VideoController(List<Video> videos) {
		this.videos = videos;
	}
	
	public void incluirVideo(String titulo, String autor, int ano, double duracao) {
		Video video = new Video(titulo, ano, autor, duracao);
		
		videos.add(video);
	}
}
