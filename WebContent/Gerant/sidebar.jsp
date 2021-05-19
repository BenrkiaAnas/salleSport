<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="app-sidebar sidebar-shadow">
                <div class="app-header__logo">
                    <div class="logo-src"></div>
                    <div class="header__pane ml-auto">
                        <div>
                            <button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
                                <span class="hamburger-box">
                                    <span class="hamburger-inner"></span>
                                </span>
                            </button>
                        </div>
                    </div>
                </div>
                <div class="app-header__mobile-menu">
                    <div>
                        <button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
                            <span class="hamburger-box">
                                <span class="hamburger-inner"></span>
                            </span>
                        </button>
                    </div>
                </div>
                <div class="app-header__menu">
                    <span>
                        <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
                            <span class="btn-icon-wrapper">
                                <i class="fa fa-ellipsis-v fa-w-6"></i>
                            </span>
                        </button>
                    </span>
                </div>    <div class="scrollbar-sidebar">
                    <div class="app-sidebar__inner">
                        <ul class="vertical-nav-menu">
                            <li  class="mm-active"      >
                                <a href="#">
                                    <i class="metismenu-icon pe-7s-rocket"></i>Acceuil
                                </a>
                                
                            </li>
                            <li>
                                <a href="/salleSport/listeEspace">
                                    <i class="metismenu-icon pe-7s-browser"></i>Espace Sportif
                                    
                                </a>
                               
                            </li>
                            
                            <li>
                                <a href="/salleSport/listeTerrain">
                                    <i class="metismenu-icon pe-7s-browser"></i>Terrain
                                   
                                </a>
                               
                            </li>
                            
                            
                            <li>
                                <a href="#">
                                    <i class="metismenu-icon pe-7s-browser"></i>Accessoire
                                    <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                                </a>
                                <ul  
                                      
                                    >
                                    <li>
                                        <a href="/salleSport/listAccessoire" >
                                            <i class="metismenu-icon"></i> Liste Accessoires
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/salleSport/createAccessoire" >
                                            <i class="metismenu-icon"></i>Crée Accessoire
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                            
                            <li>
                                <a href="#">
                                    <i class="metismenu-icon pe-7s-browser"></i>Tournoi
                                    <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                                </a>
                                <ul  
                                      
                                    >
                                    <li>
                                        <a href="/salleSport/listeTournoi" >
                                            <i class="metismenu-icon"></i> Liste Tournois
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/salleSport/createTournoi" >
                                            <i class="metismenu-icon"></i>Crée Tournoi
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                             <li>
                                <a href="#">
                                    <i class="metismenu-icon pe-7s-browser"></i>Promotion
                                    <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                                </a>
                                <ul  
                                      
                                    >
                                    <li>
                                        <a href="/salleSport/listePromotion" >
                                            <i class="metismenu-icon"></i> Liste Promotion
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/salleSport/createPromotion" >
                                            <i class="metismenu-icon"></i>Crée Promotion
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>