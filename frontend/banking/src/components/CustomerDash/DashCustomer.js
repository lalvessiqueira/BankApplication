import React, {Component} from 'react';
import './DashCustomer.css';
import DashCustomerHeader from "./DashCustomerHeader";
import DashSideBar from "./DashSideBar";
import DashCustomerAcct from "./DashCustomerAcct";
import Footer from "../Landing/Footer";
import LandingCardGroup from "../Landing/LandingCardGroup";

class DashCustomer extends Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <DashCustomerHeader/>
                </div>
                <div>
                    <section>
                        <div className="row justify-content-evenly">
                            <div className="col-md-6 mb-3">
                                <DashSideBar/>
                            </div>
                            <div className="col-md-4 mb-3">
                                <DashCustomerAcct/>
                                <DashCustomerAcct/>
                                <DashCustomerAcct/>
                            </div>
                        </div>
                    </section>
                </div>

                <div className="row my-5">
                    <h1 style={{color: "whitesmoke"}}>Financial guidance for every stage of life.</h1>
                    <h4 style={{color: "white"}}>Better Money Habits® is here to help with your decisions along the way.</h4>
                    <LandingCardGroup/>
                </div>
                <div className="row">
                    <Footer/>
                </div>
            </div>
        );
    }
}

export default DashCustomer;