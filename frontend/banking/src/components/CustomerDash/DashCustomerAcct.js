import React, {Component} from 'react';
import {
    MDBBtn,
    MDBCard,
    MDBCardBody,
    MDBCardText,
    MDBCol, MDBContainer,
    MDBRow,
    MDBSwitch
} from "mdb-react-ui-kit";

class DashCustomerAcct extends Component {
    render() {
        return (
            <MDBContainer>
                <MDBCard id='bg-glass' className='mb-3'>
                    <MDBCardBody>
                        <MDBRow className='mb-3'>
                            <MDBCardText className='pe-5 mb-1'>Account Type: </MDBCardText>
                            <MDBCardText className='pe-4'>Account Balance: </MDBCardText>
                        </MDBRow>
                        <MDBRow>
                            <MDBCol size='auto'>
                                <MDBSwitch label='Disable/Enable' defaultChecked />
                            </MDBCol>
                            <MDBCol>
                                <MDBBtn type='submit' size='sm'>View More</MDBBtn>
                            </MDBCol>
                        </MDBRow>
                    </MDBCardBody>
                </MDBCard>
            </MDBContainer>
        );
    }
}

export default DashCustomerAcct;