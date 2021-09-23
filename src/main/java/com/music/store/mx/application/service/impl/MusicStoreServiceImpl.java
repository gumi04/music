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
* Nombre de archivo: MusicStoreServiceImpl.java
* Autor: gcontrer
* Fecha de creación: 21 sep. 2021
*/

package com.music.store.mx.application.service.impl;

import com.music.store.mx.application.dto.AlbumDto;
import com.music.store.mx.application.dto.SongDto;
import com.music.store.mx.application.mapper.AlbumMapper;
import com.music.store.mx.application.mapper.SongMapper;
import com.music.store.mx.application.repository.AlbumRepository;
import com.music.store.mx.application.repository.SongRepository;
import com.music.store.mx.application.service.MusicStoreService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * The Class MusicStoreServiceImpl.
 */
@Service
public class MusicStoreServiceImpl implements MusicStoreService {

  /** The album repository. */
  private AlbumRepository albumRepository;

  /** The song repository. */
  private SongRepository songRepository;

  /**
   * Instantiates a new music store service impl.
   *
   * @param albumRepository the album repository
   * @param songRepository the song repository
   */
  public MusicStoreServiceImpl(AlbumRepository albumRepository, SongRepository songRepository) {
    this.albumRepository = albumRepository;
    this.songRepository = songRepository;
  }

  /**
   * Retrieve albums.
   *
   * @return the list
   */
  @Override
  public List<AlbumDto> retrieveAlbums() {
    return this.albumRepository.findAll().stream().map(AlbumMapper::toDto)
        .collect(Collectors.toList());
  }

  /**
   * Save album.
   *
   * @param albumDto the album dto
   * @return the album dto
   */
  @Override
  public AlbumDto saveAlbum(AlbumDto albumDto) {
    return AlbumMapper.toDto(this.albumRepository.save(AlbumMapper.toModel(albumDto)));
  }

  /**
   * Update albums.
   *
   * @param albumDto the album dto
   */
  @Override
  public void updateAlbums(AlbumDto albumDto) {
    this.retrieveAlbums().stream().forEach(alb -> {
      alb.setTitle(albumDto.getTitle());
      alb.setLaunch(albumDto.getLaunch());
      alb.setCompany(albumDto.getCompany());
      alb.setSinger(albumDto.getSinger());
      alb.setGender(albumDto.getGender());
      alb.setImage(albumDto.getImage());
      this.saveAlbum(alb);
    });
  }

  /**
   * Update album company.
   *
   * @param company the company
   * @return the boolean
   */
  @Override
  public Boolean updateAlbumCompany(String company) {
    if (this.retrieveAlbums() != null) {
      this.albumRepository.updateAlbumsCompany(company);
      return true;
    } else {
      return false;
    }

  }


  /**
   * Delete all.
   *
   * @return the boolean
   */
  @Override
  public Boolean deleteAll() {
    if (this.retrieveAlbums() != null) {
      this.albumRepository.deleteAll();
      return true;
    } else {
      return false;
    }

  }

  /**
   * Gets the album by id.
   *
   * @param albumId the album id
   * @return the album by id
   */
  @Override
  public Optional<AlbumDto> getAlbumById(Long albumId) {
    return this.albumRepository.findById(albumId).map(AlbumMapper::toDto);
  }

  /**
   * Update album.
   *
   * @param albumDto the album dto
   * @return the album dto
   */
  @Override
  public AlbumDto updateAlbum(AlbumDto albumDto) {
    return this.saveAlbum(albumDto);
  }

  /**
   * Delete album.
   *
   * @param albumId the album id
   * @return the boolean
   */
  @Override
  public Boolean deleteAlbum(Long albumId) {
    return this.getAlbumById(albumId).map(album -> {
      this.albumRepository.deleteById(albumId);
      return true;
    }).orElse(false);
  }

  /**
   * Retrieve songs by album id.
   *
   * @param albumId the album id
   * @return the list
   */
  @Override
  public List<SongDto> retrieveSongsByAlbumId(Long albumId) {
    return this.songRepository.findByAlbumId(albumId).stream().map(SongMapper::toDto)
        .collect(Collectors.toList());
  }

  /**
   * Save song.
   *
   * @param albumId the album id
   * @param songDto the song dto
   * @return the song dto
   */
  @Override
  public SongDto saveSong(Long albumId, SongDto songDto) {
    songDto.setAlbumId(albumId);
    return SongMapper.toDto(songRepository.save(SongMapper.toModel(songDto)));
  }

  /**
   * Update songs author by album id.
   *
   * @param author the author
   * @param albumId the album id
   * @return the boolean
   */
  @Override
  public Boolean updateSongsAuthorByAlbumId(String author, Long albumId) {
    if (this.retrieveSongsByAlbumId(albumId) != null) {
      this.songRepository.updateSongsAuthorByAlbumId(author, albumId);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Delete songs by album id.
   *
   * @param albumId the album id
   * @return the boolean
   */
  @Override
  public Boolean deleteSongsByAlbumId(Long albumId) {
    if (this.retrieveSongsByAlbumId(albumId) != null) {
      this.songRepository.deleteSongsByAlbumId(albumId);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Gets the song by id and album id.
   *
   * @param songId the song id
   * @param albumId the album id
   * @return the song by id and album id
   */
  @Override
  public Optional<SongDto> getSongByIdAndAlbumId(Long songId, Long albumId) {
    return this.songRepository.findByIdAndAlbumId(songId, albumId).map(SongMapper::toDto);
  }

  /**
   * Update song.
   *
   * @param albumId the album id
   * @param songDto the song dto
   * @return the song dto
   */
  @Override
  public SongDto updateSong(Long albumId, SongDto songDto) {
    return this.saveSong(albumId, songDto);
  }

  /**
   * Delete song.
   *
   * @param songId the song id
   * @param albumId the album id
   * @return the boolean
   */
  @Override
  public Boolean deleteSong(Long songId, Long albumId) {

    if (this.getSongByIdAndAlbumId(songId, albumId).isPresent()) {
      this.songRepository.deleteSong(songId, albumId);
      return true;
    } else {
      return false;
    }
  }



}
