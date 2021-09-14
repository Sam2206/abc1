import React, { useEffect, useState } from "react";
const useFetch = (url) => {
    const [data, setData] = useState(null);
    const [error, setError] = useState(null);
    const [loading, setLoading] = useState(true);
    
    useEffect(() => {
        const AC = new AbortController()

        fetch(url, { signal: AC.signal })
            .then((res) => {
                if (!res.ok) {
                    throw Error("Resource for the object not avaliable");
                }
                return res.json();
            })
            .then((data) => {
                setData(data);
                setLoading(false);
                setError(null);
                console.log(data);
            })
            .catch((err) => {
                if (err.name === 'AbortError') {
                    console.log("Fetch is Aborted")
                }
                else {
                    setError(err.message);
                    setLoading(false);
                }
            });

        return () => {
            AC.abort()
        }

    }, [url]);

    return { data, loading, error };
};

export default useFetch;