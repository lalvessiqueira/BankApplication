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
import axios from "axios";

class ViewStatement extends Component {
    constructor(props) {
        super(props);
        this.state = {
            accounts: [],
            accountNumber: "",
            accountBalance: "",
            transactionDate: "",
            reference: "",
            amount: 0,
            type: "",
            transactionBy: "Customer",
            accNo: ""
        };
    }

    componentDidMount() {
        axios.get("http://localhost:8081/api/customer/username/" + localStorage.getItem("username"))
            .then((response) => {
                // this.setState({customerId: response.data.customerId})
                axios.get("http://localhost:8081/api/customer/" + response.data.customerId + "/account")
                    .then((response) => {
                        console.log(response.data)
                        this.setState({accountNumber: response.data[0].accountNumber})
                        this.setState({accountBalance: response.data[0].accountBalance})
                        this.setState({accounts: response.data[0]})
                    })
            })
            .catch((error) => {
                console.log(error)
            });
    }

    render() {
        return (
            <MDBContainer className='rounded-3 py-3' id='bg-glass'>
                <form onSubmit={(e) => {
                    e.preventDefault()
                    console.log("this is the state")
                    console.log(this.state)}
                }>
                    <MDBRow className='d-flex justify-content-center my-3'>
                        <MDBCol className='col-4'>
                            <select className="form-select">
                                <option selected>CHECKINGS</option>
                                {/*<option value="Favorite Actor / Actress">Favorite Actor / Actress</option>*/}
                            </select>
                        </MDBCol>
                        <MDBCol className='col-4'>
                            <MDBBtn>SHOW</MDBBtn>
                        </MDBCol>
                    </MDBRow>
                </form>

                <MDBRow className='d-flex justify-content-center my-3'>
                    <MDBCol className='col-4'>
                        <label>AC No: {this.state.accountNumber}</label>
                    </MDBCol>
                    <MDBCol className='col-4'>
                        <label>Balance: ${this.state.accountBalance}</label>
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
                                {(this.state.accounts.transactions)?.map( info =>
                                    <tr>
                                        <td>{info.transactionDate.substring(0,10)}</td>
                                        <td>{info.reference}</td>
                                        <td>${info.amount}</td>
                                        <td>{info.type === "CREDIT" ? "CR" : "DB"}</td>
                                    </tr>
                                )}
                            </MDBTableBody>
                        </MDBTable>
                    </MDBCol>
                </MDBRow>
            </MDBContainer>
        );
    }
}

export default ViewStatement;