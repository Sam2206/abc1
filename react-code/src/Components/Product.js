import React from "react";
import useFetch from "./useFetch";
import { Table } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css';
const Product = () => {
    const {
        loading,
        error,
        data: productlist
    } = useFetch("http://localhost:8090/products/list");
    return (
        <div>
            {error && (
                <div>
                    <h1>{error}</h1>
                </div>
            )}
            {loading && (
                <div>
                    <h1>Loading......</h1>
                </div>
            )}
            {productlist && (
                <>
                    <div>
                        <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Description</th>
                                <th>Price</th>
                            </tr>
                        </thead>
                        {productlist.map((product) => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.code}</td>
                                <td>{product.name}</td>
                                <td>{product.description}</td>
                                <td>{product.price}</td>
                            </tr>
                        ))}
                        </Table>
                    </div>
                </>
            )}
        </div>
    );
};

export default Product;