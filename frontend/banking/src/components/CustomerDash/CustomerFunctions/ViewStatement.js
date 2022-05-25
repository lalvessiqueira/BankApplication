import React, {Component} from 'react';
import {
    MDBBtn,
    MDBCol,
    MDBContainer,
    MDBInput,
    MDBRadio,
    MDBRow,
    MDBTable,
    MDBTableBody,
    MDBTableHead
} from "mdb-react-ui-kit";

class ViewStatement extends Component {
    render() {
        return (
            <MDBContainer className='rounded-3 py-3' id='bg-glass'>
                <form>
                    <MDBRow className='d-flex justify-content-center my-3'>
                        <MDBCol className='col-4'>
                            <select className="form-select">
                                <option selected>To Account:</option>
                                <option value="Favorite Actor / Actress">Favorite Actor / Actress</option>
                            </select>
                        </MDBCol>
                        <MDBCol className='col-4'>
                            <MDBBtn>SHOW</MDBBtn>
                        </MDBCol>
                    </MDBRow>
                </form>

                <MDBRow className='d-flex justify-content-center my-3'>
                    <MDBCol className='col-4'>
                        <label>AC No: HB_159753</label>
                    </MDBCol>
                    <MDBCol className='col-4'>
                        <label>Balance: $123,456</label>
                    </MDBCol>
                </MDBRow>

                <MDBRow className='d-flex justify-content-start'>
                    <MDBCol>
                        <label className='mb-3' >Account Details</label>
                        <MDBTable>
                            <MDBTableHead dark>
                                <tr>
                                    <th scope='col'>Date</th>
                                    <th scope='col'>Reference</th>
                                    <th scope='col'>Amount</th>
                                    <th scope='col'>Cr/Db</th>
                                </tr>
                            </MDBTableHead>
                            <MDBTableBody>
                                <tr>
                                    <td>5-25-2022</td>
                                    <td>222-trnsfr-comp</td>
                                    <td>$420.69</td>
                                    <td>Cr</td>
                                </tr>
                                <tr>
                                    <td>6-10-2022</td>
                                    <td>459-credit-card</td>
                                    <td>$642.35</td>
                                    <td>Db</td>
                                </tr>
                            </MDBTableBody>
                        </MDBTable>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
        );
    }
}

export default ViewStatement;