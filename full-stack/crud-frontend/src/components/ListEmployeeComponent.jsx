import React, {useEffect, useState} from 'react'
import { listEmployees } from '../services/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

   const [employees, setEmployees] = useState([])

   const navigator = useNavigate();

    useEffect(() => {
        listEmployees().then((response) => {
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])

    function addNewEmployee(){
        navigator('/add-employee')
    }

  return (
    <div className='container table-responsive'>
        <h2 className='text-center'>Lista de Funcionários</h2>
        <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Adicionar Funcionário</button>
        <table className='table table-bordered table-hover'>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Primeiro Nome</th>
                    <th>Segundo Nome</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee => 
                    <tr key={employee.id}>
                        <td>{employee.id}</td>
                        <td>{employee.firstName}</td>
                        <td>{employee.lastName}</td>
                        <td>{employee.email}</td>
                    </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent