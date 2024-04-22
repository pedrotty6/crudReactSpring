import React, { useState } from 'react'
import { createEmployee } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const EmployeeComponent = () => {

   const [firstName, setFirstName] = useState('')
   const [lastName, setLastName] = useState('')
   const [email, setEmail] = useState('')

   const navigator = useNavigate();

    function saveEmployee(e){
        e.preventDefault();
        const employee = {firstName,lastName,email}
        console.log(employee)

        createEmployee(employee).then((response) => {
            console.log(response.data);
            navigator('/employees')
        })
    }

  return (
    <div className='container'>
        <br></br>
        <br></br>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                <h2 className='text-center'>Adicionar Funcionário</h2>
                <div className='card-body'>
                    <form>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Primeiro Nome</label>
                            <input className='form-control' type='text' placeholder='Digite o primeiro nome' 
                            name='firstName' value={firstName} 
                            onChange={(e) => setFirstName(e.target.value)}>
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Último Nome</label>
                            <input className='form-control' type='text' placeholder='Digite o último nome' 
                            name='lastName' value={lastName} 
                            onChange={(e) => setLastName(e.target.value)}>
                            </input>
                        </div>
                        <div className='form-group mb-2'>
                            <label className='form-label'>Email</label>
                            <input className='form-control' type='text' placeholder='Digite o email' 
                            name='email' value={email} 
                            onChange={(e) => setEmail(e.target.value)}>
                            </input>
                        </div>

                        <button className='btn btn-success mt-2' onClick={saveEmployee}>Confirmar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
  )
}

export default EmployeeComponent