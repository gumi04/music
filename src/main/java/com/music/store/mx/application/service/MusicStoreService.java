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
* Nombre de archivo: MusicStoreService.java
* Autor: gcontrer
* Fecha de creación: 21 sep. 2021
*/


package com.music.store.mx.application.service;


import com.music.store.mx.application.dto.AlbumDto;
import com.music.store.mx.application.dto.SongDto;
import java.util.List;
import java.util.Optional;

/**
 * The Interface MusicStoreService.
 */
public interface MusicStoreService {

  /**
   * Retrieve albums.
   *
   * @return the list
   */
  List<AlbumDto> retrieveAlbums();

  /**
   * Save album.
   *
   * @param albumDto the album dto
   * @return the album dto
   */
  AlbumDto saveAlbum(AlbumDto albumDto);

  /**
   * Update albums.
   *
   * @param albumDto the album dto
   */
  void updateAlbums(AlbumDto albumDto);

  /**
   * Delete all.
   *
   * @return the boolean
   */
  Boolean deleteAll();

  /**
   * Gets the album by id.
   *
   * @param albumId the album id
   * @return the album by id
   */
  Optional<AlbumDto> getAlbumById(Long albumId);

  /**
   * Update album.
   *
   * @param albumDto the album dto
   * @return the album dto
   */
  AlbumDto updateAlbum(AlbumDto albumDto);

  /**
   * Delete album.
   *
   * @param albumId the album id
   * @return the boolean
   */
  Boolean deleteAlbum(Long albumId);

  /**
   * Update album company.
   *
   * @param company the company
   * @return the boolean
   */
  Boolean updateAlbumCompany(String company);

  /**
   * Retrieve songs by album id.
   *
   * @param albumId the album id
   * @return the list
   */
  List<SongDto> retrieveSongsByAlbumId(Long albumId);

  /**
   * Save song.
   *
   * @param albumId the album id
   * @param songDto the song dto
   * @return the song dto
   */
  SongDto saveSong(Long albumId, SongDto songDto);

  /**
   * Update songs author by album id.
   *
   * @param author the author
   * @param albumId the album id
   * @return the boolean
   */
  Boolean updateSongsAuthorByAlbumId(String author, Long albumId);

  /**
   * Delete songs by album id.
   *
   * @param albumId the album id
   * @return the boolean
   */
  Boolean deleteSongsByAlbumId(Long albumId);

  /**
   * Gets the song by id and album id.
   *
   * @param songId the song id
   * @param albumId the album id
   * @return the song by id and album id
   */
  Optional<SongDto> getSongByIdAndAlbumId(Long songId, Long albumId);

  /**
   * Update song.
   *
   * @param albumId the album id
   * @param songDto the song dto
   * @return the song dto
   */
  SongDto updateSong(Long albumId, SongDto songDto);

  /**
   * Delete song.
   *
   * @param songId the song id
   * @param albumId the album id
   * @return the boolean
   */
  Boolean deleteSong(Long songId, Long albumId);
}
