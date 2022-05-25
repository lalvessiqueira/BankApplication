import React, {Component} from 'react';
import {MDBTable, MDBTableBody, MDBTableHead} from "mdb-react-ui-kit";

class RemoveBeneficiary extends Component {
    render() {
        return (
            <div id='bg-glass'>
                <MDBTable>
                    <MDBTableHead dark>
                        <tr>
                            <th scope='col'>Account #</th>
                            <th scope='col'>Full Name</th>
                            <th scope='col'>Delete</th>
                        </tr>
                    </MDBTableHead>
                    <MDBTableBody>
                        <tr>
                            <th>uhb_123456</th>
                            <td>Henrry</td>
                            <td><i className="fas fa-trash-alt"></i></td>
                        </tr>
                        <tr>
                            <th>uhb_123456</th>
                            <td>Henrry</td>
                            <td><i className="fas fa-trash-alt"></i></td>
                        </tr>
                    </MDBTableBody>
                </MDBTable>
            </div>
        );
    }
}

export default RemoveBeneficiary;