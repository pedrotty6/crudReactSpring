import React from 'react'
import { useNavigate } from 'react-router-dom'

const HeaderComponent = () => {

  const navigator = useNavigate();

  function returnHome(){
    navigator('/employees')
}

  return (
    <div>
        <header>
            <nav className='navbar navbar-dark bg-dark'>
                <a className='navbar-brand' href='#' onClick={returnHome}>Sistema de Cadastro</a>
            </nav>
        </header>
    </div>
  )
}

export default HeaderComponent