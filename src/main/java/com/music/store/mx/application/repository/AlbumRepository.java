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
* Nombre de archivo: AlbumRepository.java
* Autor: gcontrer
* Fecha de creación: 21 sep. 2021
*/


package com.music.store.mx.application.repository;

import com.music.store.mx.model.Album;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



/**
 * The Interface AlbumRepository.
 */
public interface AlbumRepository extends JpaRepository<Album, Long> {

  /**
   * Find all.
   *
   * @return the list
   */
  List<Album> findAll();

  /**
   * Save.
   *
   * @param album the album
   * @return the album
   */
  Album save(Album album);

  /**
   * Delete all.
   */
  void deleteAll();

  /**
   * Find by id.
   *
   * @param albumId the album id
   * @return the optional
   */
  Optional<Album> findById(Long albumId);

  /**
   * Delete by id.
   *
   * @param albumId the album id
   */
  void deleteById(Long albumId);
  
  /**
   * Update albums company.
   *
   * @param company the company
   */
  @Transactional
  @Modifying
  @Query(value = "UPDATE Album set disquera = ?", nativeQuery = true)
  void updateAlbumsCompany(String company);


}
