import React, {Component} from 'react';
import {
    MDBBtn,
    MDBCol, MDBContainer, MDBInput, MDBRadio, MDBRow,
    MDBTable,
    MDBTableBody,
    MDBTableHead
} from "mdb-react-ui-kit";

class TransferMoney extends Component {
    render() {
        return (
            <MDBContainer className='rounded-3 py-3' id='bg-glass'>
                <form>
                    <MDBRow className='d-flex justify-content-start'>
                        <MDBCol>
                            <label className='mb-3'>From Account:</label>
                            <MDBTable>
                                <MDBTableHead dark>
                                    <tr>
                                        <th scope='col'>Account #</th>
                                        <th scope='col'>Balance</th>
                                        <th scope='col'>Account Type</th>
                                        <th scope='col'>Select</th>
                                    </tr>
                                </MDBTableHead>
                                <MDBTableBody>
                                    <tr>
                                        <td>12345</td>
                                        <td>USD: 25,000</td>
                                        <td>CA</td>
                                        <td><MDBRadio name='accountRadio'/></td>
                                    </tr>
                                    <tr>
                                        <td>67890</td>
                                        <td>USD: 69,420</td>
                                        <td>SB</td>
                                        <td><MDBRadio name='accountRadio'/></td>
                                    </tr>
                                </MDBTableBody>
                            </MDBTable>
                        </MDBCol>
                    </MDBRow>

                    <MDBRow className='d-flex justify-content-center my-3'>
                        <MDBCol className='col-4'>
                            <select className="form-select">
                                <option selected>To Account:</option>
                                <option value="Favorite Actor / Actress">Favorite Actor / Actress</option>
                            </select>
                        </MDBCol>
                        <MDBCol className='col-4'>
                            <MDBInput label='Enter Amount'/>
                        </MDBCol>
                    </MDBRow>
                    <MDBRow className='d-flex justify-content-center my-3'>
                        <MDBCol className='col-8'>
                            <MDBInput label='Include Comment'/>
                        </MDBCol>
                    </MDBRow>
                    <MDBBtn>Transfer</MDBBtn>
                </form>
            </MDBContainer>
        );
    }
}

export default TransferMoney;