/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.lojamodelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Conecta {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lojaWEB-Modelo01PU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = null;
}
