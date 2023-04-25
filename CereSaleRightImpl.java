    public Page getAll(SaleRightDTO param) {

        PageHelper.startPage(param.getPage(), param.getPageSize());
        QueryWrapper<CereSaleRight> wrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(param.getRightName())) {
            wrapper.like("right_name", param.getRightName());
        }
        if (param.getEnabled() != null) {
            wrapper.eq("enabled", param.getEnabled());
        }
        List<CereSaleRight> list = cereSaleRightDAO.selectList(wrapper);
        PageInfo<CereSaleRight> pageInfo = new PageInfo<>(list);
        Page page = new Page(pageInfo.getList(), pageInfo.getTotal());

        return page;
    }
