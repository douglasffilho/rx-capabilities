package br.com.douglasffilho.rxcapabilities.domain

interface Actor<S> {

    S doAction(String actionName)

}