import React, {Component} from 'react';
import {
    MDBBtn,
    MDBCard,
    MDBCardBody,
    MDBCardText,
    MDBCol,
    MDBRow,
    MDBSwitch
} from "mdb-react-ui-kit";

class DashCustomerAcct extends Component {
    render() {
        return (
            <div className='container'>
                <MDBCard id='bg-glass' className='mb-3'>
                    <MDBCardBody>
                        <div className='row mb-3'>
                            <MDBCardText className='pe-5 mb-1'>Account Type: </MDBCardText>
                            <MDBCardText className='pe-4'>Account Balance: </MDBCardText>
                        </div>
                        <div>
                            <MDBRow className='align-items-center'>
                                <MDBCol size='auto'>
                                    <MDBSwitch label='Disable/Enable' defaultChecked />
                                </MDBCol>
                                <MDBCol>
                                    <MDBBtn type='submit' size='sm'>View More</MDBBtn>
                                </MDBCol>
                            </MDBRow>
                        </div>
                    </MDBCardBody>
                </MDBCard>
            </div>
        );
    }
}

export default DashCustomerAcct;