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
                                <a href="#">
                                    <i class="metismenu-icon pe-7s-browser"></i>Plans
                                    <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                                </a>
                                <ul  
                                      
                                    >
                                    <li>
                                        <a href="/listPlan" >
                                            <i class="metismenu-icon"></i> Liste Plans
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/createPlan" >
                                            <i class="metismenu-icon"></i>Crée Plan
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                            
                            <li>
                                <a href="#">
                                    <i class="metismenu-icon pe-7s-browser"></i>Catégories
                                    <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                                </a>
                                <ul  
                                      
                                    >
                                    <li>
                                        <a href="/listeCategorie" >
                                            <i class="metismenu-icon"></i> Liste Catégories
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/createCategorie" >
                                            <i class="metismenu-icon"></i>Crée Catégorie
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                            
                            <li>
                                <a href="/listeGerant">
                                    <i class="metismenu-icon pe-7s-browser"></i>Gérants
                                </a>
                                
                            </li>
                            <li>
                                <a href="#">
                                    <i class="metismenu-icon pe-7s-browser"></i>Espaces Sportif
                                    <i class="metismenu-state-icon pe-7s-angle-down caret-left"></i>
                                </a>
                                <ul  
                                      
                                    >
                                    <li>
                                        <a href="pages-login.html" >
                                            <i class="metismenu-icon"></i> Liste Espaces
                                        </a>
                                    </li>
                                    <li>
                                        <a href="pages-login-boxed.html" >
                                            <i class="metismenu-icon"></i>Crée Espace
                                        </a>
                                    </li>
                                    
                                </ul>
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </div>