const phones = (() => {
    const products = [
        {
            img: 'url(https://cdn.mobilecity.vn/mobilecity-vn/images/2021/04/w150/xiaomi-redmi-k40-pro-2-1.jpg)',
            name: 'Xiaomi Redmi K40 Pro (K40 Pro+)',
            price: '8.750.000 đ',
            markerList: ['hot', 'new'],
            linkProduct: '#',
            linkGuarantee: '#',
        },
        {
            img: 'url(https://cdn.mobilecity.vn/mobilecity-vn/images/2021/03/w150/redmi-k40-full.jpg)',
            name: 'Xiaomi Redmi K40',
            price: '7.350.000 đ',
            markerList: [],
            linkProduct: '#',
            linkGuarantee: '#',
        },
        {
            img: 'url(https://cdn.mobilecity.vn/mobilecity-vn/images/2021/02/w150/asus-rog-phone-5-render-1-1200x675-800-resize.jpg)',
            name: 'Asus ROG Phone 5 (Snap888)',
            price: '14.650.000 đ',
            markerList: ['hot', 'new'],
            linkProduct: '#',
            linkGuarantee: '#',
        },
        {
            img: 'url(https://cdn.mobilecity.vn/mobilecity-vn/images/2021/02/w150/vivo-iqoo-7-white.jpg)',
            name: 'Vivo iQOO 7 (Snap 888)',
            price: '12.450.000 đ',
            markerList: [],
            linkProduct: '#',
            linkGuarantee: '#',
        },
        {
            img: 'url(https://cdn.mobilecity.vn/mobilecity-vn/images/2021/04/w150/asus-rog-phone-3.jpg)',
            name: 'Asus ROG Phone 3 Tencent',
            price: '11.950.000 đ',
            markerList: [],
            linkProduct: '#',
            linkGuarantee: '#',
        },
        {
            img: 'url(https://cdn.mobilecity.vn/mobilecity-vn/images/2019/09/w150/iphone-11-pro.jpg)',
            name: 'iPhone 11 Pro (64GB, 256GB)',
            price: '19.950.000 đ',
            markerList: [],
            linkProduct: '#',
            linkGuarantee: '#',
        },
        {
            img: 'url(https://cdn.mobilecity.vn/mobilecity-vn/images/2019/09/w150/iphone-11-3.jpg)',
            name: 'iPhone 11 (64GB, 256GB)',
            price: '11.450.000 đ',
            markerList: [],
            linkProduct: '#',
            linkGuarantee: '#',
        },
    ];

    const banners = [
        {
            img: './banner/banner1.jpg',
            link: '#'
        },
        {
            img: './banner/banner2.jpg',
            link: '#'
        },
        {
            img: './banner/banner3.jpg',
            link: '#'
        },
    ]

    let currentBanner = 0;
    const prevBtn = document.querySelector('.phone-banner__btn-prev');
    const nextBtn = document.querySelector('.phone-banner__btn-next');
    let firstBanner;
    let bannerPaginationBtns;
    let setTimeChangeBanner;

    return {
        render() {
            const htmlPhone = products.map(product => {
                const markers = product.markerList.reduce((acc, curr) => {
                    return acc + `active-marker--${curr} `;
                }, '');
                return `
                
                `;
            }).join('');

            //document.querySelector('.phone-products').innerHTML = htmlPhone;

            const percent = 100 / banners.length;
            const bannerPaginations = [];
            const htmlBanner = banners.map((banner, index) => {
                let first = '';
                if (index === 0) {
                    first = 'banner--first';
                    bannerPaginations.push(`<div data-set="${percent*index}%" class="phone-banner-pagination__item active"></div>`);
                } else {
                    bannerPaginations.push(`<div data-set="-${percent*index}%" class="phone-banner-pagination__item"></div>`);
                }
                return `
                    <a href=${banner.link} class="banner__link ${first}" style="width: ${percent}%">
                        <img src=${banner.img} alt="Banner ${index + 1}" class="banner__img">
                    </a>
                `
            }, '').join('');

            document.querySelector('.phone-banner__list').innerHTML = htmlBanner;
            document.querySelector('.phone-banner__list').style.width = `${banners.length * 100}%`;
            document.querySelector('.phone-banner-pagination').innerHTML = bannerPaginations.join('');
        },
        handleBanner() {
            const _this = this;
            firstBanner = document.querySelector('.banner--first');
            bannerPaginationBtns = document.querySelectorAll('.phone-banner-pagination__item');

            prevBtn.onclick = () => {
                this.prevBanner();
                this.autoChangeBanner(true);
            }

            nextBtn.onclick = () => {
                this.nextBanner();
                this.autoChangeBanner(true);
            }

            bannerPaginationBtns.forEach(function(btn, index) {
                btn.onclick = () => {
                    currentBanner = index;
                    firstBanner.style.marginLeft = bannerPaginationBtns[currentBanner].dataset.set;
                    document.querySelector('.phone-banner-pagination__item.active').classList.remove('active');
                    bannerPaginationBtns[currentBanner].classList.add('active');
                    _this.autoChangeBanner(true);
                }
            });
        },
        prevBanner() {
            currentBanner -= 1;
            if (currentBanner < 0) {
                currentBanner = banners.length - 1;
            };
            firstBanner.style.marginLeft = bannerPaginationBtns[currentBanner].dataset.set;
            document.querySelector('.phone-banner-pagination__item.active').classList.remove('active');
            bannerPaginationBtns[currentBanner].classList.add('active');
        },
        nextBanner() {
            currentBanner += 1;
            if (currentBanner > banners.length - 1) {
                currentBanner = 0;
            };
            firstBanner.style.marginLeft = bannerPaginationBtns[currentBanner].dataset.set;
            document.querySelector('.phone-banner-pagination__item.active').classList.remove('active');
            bannerPaginationBtns[currentBanner].classList.add('active');
        },
        autoChangeBanner(isClick) {
            const _this = this;
            if (isClick) {
                clearInterval(setTimeChangeBanner);
                setTimeChangeBanner = setInterval(function() {
                    _this.nextBanner();
                }, 3000);
            } else {  
                setTimeChangeBanner = setInterval(function() {
                    _this.nextBanner();
                }, 3000);
            }
        },
        init() {
            this.render();
            this.handleBanner();
            this.autoChangeBanner();
        }
    }
})();

phones.init();