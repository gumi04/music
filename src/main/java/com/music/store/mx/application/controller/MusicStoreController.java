/* 
* This program is free software: you can redistribute it and/or modify  
* it under the terms of the GNU General Public License as published by  
* the Free Software Foundation, version 3.
*
* This program is distributed in the hope that it will be useful, but 
* WITHOUT ANY WARRANTY; without even the implied warranty of 
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
* General Public License for more details.
*
* Nombre de archivo: MusicStoreController.java
* Autor: gcontrer
* Fecha de creación: 21 sep. 2021
*/

package com.music.store.mx.application.controller;

import com.music.store.mx.application.dto.AlbumDto;
import com.music.store.mx.application.dto.SongDto;
import com.music.store.mx.application.service.MusicStoreService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * The Class MusicStoreController.
 */
@RestController
public class MusicStoreController {

  /** The music store servie. */
  private MusicStoreService musicStoreServie;

  /**
   * Instantiates a new music store controller.
   *
   * @param musicStoreServie the music store servie
   */
  public MusicStoreController(MusicStoreService musicStoreServie) {
    this.musicStoreServie = musicStoreServie;
  }

  /**
   * Gets the albums.
   *
   * @return the albums
   */
  @GetMapping(value = "/api/v1/albums", produces = "application/json")
  public ResponseEntity<List<AlbumDto>> getAlbums() {
    return new ResponseEntity<>(musicStoreServie.retrieveAlbums(), HttpStatus.OK);
  }

  /**
   * Save album.
   *
   * @param albumDto the album dto
   * @return the response entity
   */
  @PostMapping(value = "/api/v1/albums")
  public ResponseEntity<AlbumDto> saveAlbum(@RequestBody AlbumDto albumDto) {
    return new ResponseEntity<>(musicStoreServie.saveAlbum(albumDto), HttpStatus.CREATED);
  }

  /**
   * Update albums.
   *
   * @param albumDto the album dto
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums")
  public ResponseEntity updateAlbums(@RequestBody AlbumDto albumDto) {
    if (musicStoreServie.updateAlbumCompany(albumDto.getCompany())) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // musicStoreServie.updateAlbums(albumDto);
    // return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Deleted all albums.
   *
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums")
  public ResponseEntity deletedAllAlbums() {
    if (musicStoreServie.deleteAll()) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Gets the album.
   *
   * @param albumId the album id
   * @return the album
   */
  @GetMapping(value = "/api/v1/albums/{id}", produces = "application/json")
  public ResponseEntity<AlbumDto> getAlbum(@PathVariable("id") Long albumId) {
    return musicStoreServie.getAlbumById(albumId)
        .map(album -> new ResponseEntity<>(album, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  /**
   * Update album.
   *
   * @param albumId the album id
   * @param albumDto the album dto
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums/{id}")
  public ResponseEntity<AlbumDto> updateAlbum(@PathVariable("id") Long albumId,
      @RequestBody AlbumDto albumDto) {
    return new ResponseEntity<>(musicStoreServie.updateAlbum(albumDto), HttpStatus.CREATED);
  }

  /**
   * Delete album.
   *
   * @param albumId the album id
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums/{id}")
  public ResponseEntity deleteAlbum(@PathVariable("id") Long albumId) {
    if (this.musicStoreServie.deleteAlbum(albumId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Gets the songs by album id.
   *
   * @param albumId the album id
   * @return the songs by album id
   */
  @GetMapping(value = "/api/v1/albums/{id}/songs")
  public ResponseEntity<List<SongDto>> getSongsByAlbumId(@PathVariable("id") Long albumId) {
    return new ResponseEntity<>(this.musicStoreServie.retrieveSongsByAlbumId(albumId),
        HttpStatus.OK);
  }

  /**
   * Save song.
   *
   * @param albumId the album id
   * @param songDto the song dto
   * @return the response entity
   */
  @PostMapping(value = "/api/v1/albums/{id}/songs")
  public ResponseEntity<SongDto> saveSong(@PathVariable("id") Long albumId,
      @RequestBody SongDto songDto) {
    return new ResponseEntity<>(musicStoreServie.saveSong(albumId, songDto), HttpStatus.CREATED);

  }

  /**
   * Update songs author by id.
   *
   * @param albumId the album id
   * @param songDto the song dto
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums/{id}/songs")
  public ResponseEntity updateSongsAuthorById(@PathVariable("id") Long albumId,
      @RequestBody SongDto songDto) {
    if (musicStoreServie.updateSongsAuthorByAlbumId(songDto.getAuthor(), albumId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Delete songs by album id.
   *
   * @param albumId the album id
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums/{id}/songs")
  public ResponseEntity deleteSongsByAlbumId(@PathVariable("id") Long albumId) {
    if (musicStoreServie.deleteSongsByAlbumId(albumId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  /**
   * Gets the song by id.
   *
   * @param albumId the album id
   * @param songId the song id
   * @return the song by id
   */
  @GetMapping(value = "/api/v1/albums/{albumId}/songs/{songId}", produces = "application/json")
  public ResponseEntity<SongDto> getSongById(@PathVariable("albumId") Long albumId,
      @PathVariable("songId") Long songId) {
    return musicStoreServie.getSongByIdAndAlbumId(songId, albumId)
        .map(song -> new ResponseEntity<>(song, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  /**
   * Update song.
   *
   * @param albumId the album id
   * @param songId the song id
   * @param songDto the song dto
   * @return the response entity
   */
  @PutMapping(value = "/api/v1/albums/{albumId}/songs/{songId}")
  public ResponseEntity<SongDto> updateSong(@PathVariable("albumId") Long albumId,
      @PathVariable("songId") Long songId, @RequestBody SongDto songDto) {
    songDto.setSongId(songId);
    return new ResponseEntity<>(musicStoreServie.updateSong(albumId, songDto), HttpStatus.CREATED);
  }

  /**
   * Delete song.
   *
   * @param albumId the album id
   * @param songId the song id
   * @return the response entity
   */
  @DeleteMapping(value = "/api/v1/albums/{albumId}/songs/{songId}")
  public ResponseEntity deleteSong(@PathVariable("albumId") Long albumId,
      @PathVariable("songId") Long songId) {
    if (musicStoreServie.deleteSong(songId, albumId)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }


}
